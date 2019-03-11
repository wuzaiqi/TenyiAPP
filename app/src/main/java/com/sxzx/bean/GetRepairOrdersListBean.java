package com.sxzx.bean;

import java.util.List;

//获取订单Bean
public class GetRepairOrdersListBean {

    /**
     * error_code : 0
     * msg : 获取成功
     * count : 21
     * orderList : [{"order_id":32,
     * "trade_no":"201901042211063939",
     * "tb_id":1,
     * "lab_id":1,
     * "computer_id":"5,7,17,19,29,41,53",
     * "fault_id":1,
     * "memo":"测试测试测试测试测试测试测试测试测试测试测试",
     * "user_id":1,
     * "create_date":1546611066,
     * "maintenance_id":null,
     * "processing_date":null,
     * "status":0,
     * "tb_name":"第一教学楼",
     * "lab_name":"1201","fault_type":"硬件故障","username":"王万锋"}]
     */

    private int error_code;
    private String msg;
    private int count;
    private List<OrderListBean> orderList;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * order_id : 32
         * trade_no : 201901042211063939
         * tb_id : 1
         * lab_id : 1
         * computer_id : 5,7,17,19,29,41,53
         * fault_id : 1
         * memo : 测试测试测试测试测试测试测试测试测试测试测试
         * user_id : 1
         * create_date : 1546611066
         * maintenance_id : null
         * processing_date : null
         * status : 0
         * tb_name : 第一教学楼
         * lab_name : 1201
         * fault_type : 硬件故障
         * username : 王万锋
         */

        private int order_id;
        private String trade_no;
        private int tb_id;
        private int lab_id;
        private String computer_id;
        private int fault_id;
        private String memo;
        private int user_id;
        private int create_date;
        private Object maintenance_id;
        private Object processing_date;
        private int status;
        private String tb_name;
        private String lab_name;
        private String fault_type;
        private String username;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getTrade_no() {
            return trade_no;
        }

        public void setTrade_no(String trade_no) {
            this.trade_no = trade_no;
        }

        public int getTb_id() {
            return tb_id;
        }

        public void setTb_id(int tb_id) {
            this.tb_id = tb_id;
        }

        public int getLab_id() {
            return lab_id;
        }

        public void setLab_id(int lab_id) {
            this.lab_id = lab_id;
        }

        public String getComputer_id() {
            return computer_id;
        }

        public void setComputer_id(String computer_id) {
            this.computer_id = computer_id;
        }

        public int getFault_id() {
            return fault_id;
        }

        public void setFault_id(int fault_id) {
            this.fault_id = fault_id;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getCreate_date() {
            return create_date;
        }

        public void setCreate_date(int create_date) {
            this.create_date = create_date;
        }

        public Object getMaintenance_id() {
            return maintenance_id;
        }

        public void setMaintenance_id(Object maintenance_id) {
            this.maintenance_id = maintenance_id;
        }

        public Object getProcessing_date() {
            return processing_date;
        }

        public void setProcessing_date(Object processing_date) {
            this.processing_date = processing_date;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTb_name() {
            return tb_name;
        }

        public void setTb_name(String tb_name) {
            this.tb_name = tb_name;
        }

        public String getLab_name() {
            return lab_name;
        }

        public void setLab_name(String lab_name) {
            this.lab_name = lab_name;
        }

        public String getFault_type() {
            return fault_type;
        }

        public void setFault_type(String fault_type) {
            this.fault_type = fault_type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
