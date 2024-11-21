package com.evc.expense_tracker.repository;

import com.evc.expense_tracker.DAO.ExpenseDAO;
import com.evc.expense_tracker.entity.Expense;
import com.evc.expense_tracker.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ExpenseRepository implements ExpenseDAO {
    EntityManager entityManager;

    @Autowired
    ExpenseRepository(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public Expense save(Expense expense) {
        return expense;
    }

    @Override
    public Expense findById(Long id) {
        TypedQuery<Expense> tq= entityManager.createQuery("Select e FROM Expense e WHERE e.id=:theData ", Expense.class);
        tq.setParameter("theData",id);
        return tq.getSingleResult();
    }

    @Override
    public List<Expense> findByUserId(Long userId) {
        TypedQuery<Expense> tq= entityManager.createQuery("Select e FROM Expense e WHERE e.connection=:theData ", Expense.class);
        tq.setParameter("theData",userId);
        return tq.getResultList();
    }

    @Override
    public List<Expense> findAll() {
        TypedQuery<Expense> tq= entityManager.createQuery("Select e FROM Expense e ", Expense.class);
        return tq.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Expense expense = findById(id);

        if (expense != null) {
            entityManager.remove(expense);
        }
    }
}
