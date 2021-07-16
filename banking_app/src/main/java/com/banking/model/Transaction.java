package com.banking.model;

public class Transaction {
private int tid;
private String ttype;
private float openingbalance;
private float tamount;
private float closingbalance;
private int accno;
public Transaction(int tid, String ttype, float openingbalance, float tamount, float closingbalance, int accno) {
	super();
	this.tid = tid;
	this.ttype = ttype;
	this.openingbalance = openingbalance;
	this.tamount = tamount;
	this.closingbalance = closingbalance;
	this.accno = accno;
}
public Transaction() {
	// TODO Auto-generated constructor stub
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTtype() {
	return ttype;
}
public void setTtype(String ttype) {
	this.ttype = ttype;
}
public float getOpeningbalance() {
	return openingbalance;
}
public void setOpeningbalance(float openingbalance) {
	this.openingbalance = openingbalance;
}
public float getTamount() {
	return tamount;
}
public void setTamount(float tamount) {
	this.tamount = tamount;
}
public float getClosingbalance() {
	return closingbalance;
}
public void setClosingbalance(float closingbalance) {
	this.closingbalance = closingbalance;
}
public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}
public Transaction(String ttype,float openingbalance,float tamount,float closingbalance,int accno) {
	this.ttype = ttype;
	this.tamount = tamount;
	this.closingbalance = closingbalance;
	this.accno = accno;
	this.openingbalance = openingbalance;
}
@Override
public String toString() {
	return "Transaction [tid=" + tid + ", ttype=" + ttype + ", openingbalance=" + openingbalance + ", tamount="
			+ tamount + ", closingbalance=" + closingbalance + ", accno=" + accno + "]";
}


}