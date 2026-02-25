package com.fintechhibernateJPA;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TransactionDAO {
	
	EntityManager em = JpaUtil.getEntityManager();
	
	public void save(Transaction txn, Long accountId) {
		EntityTransaction et = em.getTransaction();	
		BankAccount ba = em.find(BankAccount.class, accountId);
	
		et.begin();
		ba.addTransaction(txn);
		em.persist(txn);
		et.commit();
	}
	
	public List<Transaction> findByAccount(Long accountId) {
		return em.createQuery(
		        "SELECT t FROM Transaction t WHERE t.account.accountId = :id",
		        Transaction.class)
		        .setParameter("id", accountId)
		        .getResultList();
	}
	
	public List<Transaction> findByType(Long accountId, String type){

	    return em.createQuery(
	        "SELECT t FROM Transaction t " +
	        "WHERE t.account.accountId = :id AND t.txnType = :type " +
	        "ORDER BY t.txnDate DESC",
	        Transaction.class)
	        .setParameter("id", accountId)
	        .setParameter("type", type)
	        .getResultList();
	}
	
}
