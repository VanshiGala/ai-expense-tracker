from fastapi import APIRouter
from fastapi import Depends
from sqlalchemy.orm import Session

from app.config.db import get_db
from app.models.user import User
from app.schemas.user import UserCreate
from app.utils.auth import hash_password


router = APIRouter(prefix="/auth", tags=["Auth"])


@router.post("/register")
def register(user: UserCreate, db: Session = Depends(get_db)):

    new_user = User(
        name=user.name,
        email=user.email,
        password=hash_password(user.password)
    )

    db.add(new_user)
    db.commit()
    db.refresh(new_user)

    return {
        "message": "User registered successfully"
    }