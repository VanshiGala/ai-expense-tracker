from fastapi import APIRouter
from fastapi import Depends
from sqlalchemy.orm import Session

from app.config.db import get_db
from app.services.analysis import total_expense


router = APIRouter(prefix="/insights", tags=["Insights"])


@router.get("/summary")
def summary(db: Session = Depends(get_db)):

    total = total_expense(db)

    return {
        "total_expense": total
    }