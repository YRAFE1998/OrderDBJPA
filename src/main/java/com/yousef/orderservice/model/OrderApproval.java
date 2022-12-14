package com.yousef.orderservice.model;

import javax.persistence.Entity;

@Entity
public class OrderApproval extends BaseEntity{
    private String approvedBy;

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderApproval)) return false;
        if (!super.equals(o)) return false;

        OrderApproval that = (OrderApproval) o;

        return getApprovedBy() != null ? getApprovedBy().equals(that.getApprovedBy()) : that.getApprovedBy() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getApprovedBy() != null ? getApprovedBy().hashCode() : 0);
        return result;
    }
}
