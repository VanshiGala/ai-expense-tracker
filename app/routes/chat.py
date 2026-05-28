from fastapi import APIRouter
from pydantic import BaseModel
from sqlalchemy.orm import Session
from fastapi import Depends

from app.config.db import get_db
from app.models.expense import Expense
from app.services.gemini import model


router = APIRouter(prefix="/chat", tags=["Chat"])


class ChatRequest(BaseModel):
    question: str


@router.post("/")
def finance_chat(
    data: ChatRequest,
    db: Session = Depends(get_db)
):

    expenses = db.query(Expense).all()

    expense_data = []

    for expense in expenses:
        expense_data.append({
            "title": expense.title,
            "amount": expense.amount,
            "category": expense.category,
            "merchant": expense.merchant
        })

    prompt = f"""
    You are a finance assistant.

    User expenses:

    {expense_data}

    Answer this question:
    {data.question}
    """

    response = model.generate_content(prompt)

    return {
        "answer": response.text
    }