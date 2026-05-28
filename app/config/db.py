#db configuration + connection manager

from sqlalchemy import create_engine
from sqlalchemy.orm import declarative_base
#every API req gets its own db session
#why session? -> db opr happen inside sessions
from sqlalchemy.orm import sessionmaker
#load env variabels
from app.config.settings import settings

#connection to db
engine = create_engine(settings.DATABASE_URL)

#session factory
SessionLocal = sessionmaker(
    autocommit=False,#changes NOT saved automatically
    autoflush=False,#won't auto-sync changes immediately
    bind=engine
)

Base = declarative_base()


def get_db():
    db = SessionLocal()
    try:
        yield db #session to API routes
    finally:
        db.close()