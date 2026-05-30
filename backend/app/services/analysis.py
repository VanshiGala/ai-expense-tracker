from sqlalchemy.orm import Session
from sqlalchemy import func

from app.models.expense import Expense



def total_expense(db: Session):

    total = db.query(
        func.sum(Expense.amount)
    ).scalar()

    return total or 0