from fastapi import APIRouter
from fastapi import Depends
from sqlalchemy.orm import Session

from app.config.db import get_db
from app.models.expense import Expense
from app.schemas.expense import ExpenseCreate


router = APIRouter(prefix="/expenses", tags=["Expenses"])


@router.post("/")
def create_expense(
    expense: ExpenseCreate,
    db: Session = Depends(get_db)
):

    new_expense = Expense(
        title=expense.title,
        amount=expense.amount,
        category=expense.category,
        merchant=expense.merchant,
        user_id=1
    )

    db.add(new_expense)
    db.commit()
    db.refresh(new_expense)

    return new_expense


@router.get("/")
def get_expenses(db: Session = Depends(get_db)):
    return db.query(Expense).all()