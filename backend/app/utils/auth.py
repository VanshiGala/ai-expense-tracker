from datetime import datetime
from datetime import timedelta

from jose import jwt
from passlib.context import CryptContext

from app.config.settings import settings


pwd_context = CryptContext(
    schemes=["bcrypt"],
    deprecated="auto"
)


def hash_password(password: str):
    return pwd_context.hash(password)



def verify_password(plain, hashed):
    return pwd_context.verify(plain, hashed)



def create_access_token(data: dict):
    to_encode = data.copy()

    expire = datetime.utcnow() + timedelta(days=1)

    to_encode.update({"exp": expire})

    return jwt.encode(
        to_encode,
        settings.JWT_SECRET,
        algorithm=settings.ALGORITHM
    )