package cn.car.manage.beans.orm.item.repair;

/**
 * @Description:申请维修信息类
 * @author 
 * @date 2018年3月10日 
 */
public class ApplyRepair {

		//维修ID
		private int repairID;
		
		//商品型号
		private String itemModelNum;
		
		//客户名称
		private String customerName;
		
		//维修日期
		private int repairDate;
		
		//商品编码（唯一）
		private String itemCode;
		
		//维修位置
		private String repairPosition;
		
		//损坏原因
		private String damagedReason;
		
		//申请状态
		private int applyState;
		
		//创建时间
		private int createDate;

		public ApplyRepair() {
			super();
		}

		public ApplyRepair(int repairID, String itemModelNum, String customerName, int repairDate, String itemCode,
				String repairPosition, String damagedReason, int applyState, int createDate) {
			super();
			this.repairID = repairID;
			this.itemModelNum = itemModelNum;
			this.customerName = customerName;
			this.repairDate = repairDate;
			this.itemCode = itemCode;
			this.repairPosition = repairPosition;
			this.damagedReason = damagedReason;
			this.applyState = applyState;
			this.createDate = createDate;
		}

		public int getRepairID() {
			return repairID;
		}

		public void setRepairID(int repairID) {
			this.repairID = repairID;
		}

		public String getItemModelNum() {
			return itemModelNum;
		}

		public void setItemModelNum(String itemModelNum) {
			this.itemModelNum = itemModelNum;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public int getRepairDate() {
			return repairDate;
		}

		public void setRepairDate(int repairDate) {
			this.repairDate = repairDate;
		}

		public String getItemCode() {
			return itemCode;
		}

		public void setItemCode(String itemCode) {
			this.itemCode = itemCode;
		}

		public String getRepairPosition() {
			return repairPosition;
		}

		public void setRepairPosition(String repairPosition) {
			this.repairPosition = repairPosition;
		}

		public String getDamagedReason() {
			return damagedReason;
		}

		public void setDamagedReason(String damagedReason) {
			this.damagedReason = damagedReason;
		}

		public int getApplyState() {
			return applyState;
		}

		public void setApplyState(int applyState) {
			this.applyState = applyState;
		}

		public int getCreateDate() {
			return createDate;
		}

		public void setCreateDate(int createDate) {
			this.createDate = createDate;
		}

		@Override
		public String toString() {
			return "ApplyRepair [repairID=" + repairID + ", itemModelNum=" + itemModelNum + ", customerName="
					+ customerName + ", repairDate=" + repairDate + ", itemCode=" + itemCode + ", repairPosition="
					+ repairPosition + ", damagedReason=" + damagedReason + ", applyState=" + applyState
					+ ", createDate=" + createDate + "]";
		}
		
		
		
		
}
