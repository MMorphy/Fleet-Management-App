package hr.petkovic.fleet.entities.rent;

import java.util.Collection;

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.entities.vehicle.CarGroup;

public class ReservationDTO {

	private Long id;

	private String checkOutTime;

	private Office checkOutOffice;

	private String checkInTime;

	private Office checkInOffice;

	private User user;

	private CarGroup carGroup;

	private boolean T;

	private boolean TI;

	private boolean GF;

	private boolean TG;

	private boolean TP;

	private boolean PAP;

	private boolean OW;

	private boolean IT;

	private boolean NV;

	private boolean PF;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public Office getCheckOutOffice() {
		return checkOutOffice;
	}

	public void setCheckOutOffice(Office checkOutOffice) {
		this.checkOutOffice = checkOutOffice;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Office getCheckInOffice() {
		return checkInOffice;
	}

	public void setCheckInOffice(Office checkInOffice) {
		this.checkInOffice = checkInOffice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CarGroup getCarGroup() {
		return carGroup;
	}

	public void setCarGroup(CarGroup carGroup) {
		this.carGroup = carGroup;
	}

	public boolean isT() {
		return T;
	}

	public void setT(boolean t) {
		T = t;
	}

	public boolean isTI() {
		return TI;
	}

	public void setTI(boolean tI) {
		TI = tI;
	}

	public boolean isGF() {
		return GF;
	}

	public void setGF(boolean gF) {
		GF = gF;
	}

	public boolean isTG() {
		return TG;
	}

	public void setTG(boolean tG) {
		TG = tG;
	}

	public boolean isTP() {
		return TP;
	}

	public void setTP(boolean tP) {
		TP = tP;
	}

	public boolean isPAP() {
		return PAP;
	}

	public void setPAP(boolean pAP) {
		PAP = pAP;
	}

	public boolean isOW() {
		return OW;
	}

	public void setOW(boolean oW) {
		OW = oW;
	}

	public boolean isIT() {
		return IT;
	}

	public void setIT(boolean iT) {
		IT = iT;
	}

	public boolean isNV() {
		return NV;
	}

	public void setNV(boolean nV) {
		NV = nV;
	}

	public boolean isPF() {
		return PF;
	}

	public void setPF(boolean pF) {
		PF = pF;
	}

}
