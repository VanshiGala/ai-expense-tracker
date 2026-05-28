from sqlalchemy import Column
from sqlalchemy import Integer
from sqlalchemy import String
from sqlalchemy import ForeignKey

from app.config.db import Base


class Receipt(Base):
    __tablename__ = "receipts"

    id = Column(Integer, primary_key=True, index=True)
    image_path = Column(String)
    extracted_text = Column(String)
    expense_id = Column(Integer, ForeignKey("expenses.id"))