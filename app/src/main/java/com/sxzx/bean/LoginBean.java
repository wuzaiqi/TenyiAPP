package com.sxzx.bean;


public class LoginBean {


    /**
     * error_code : 0
     * msg : 登录成功
     * token : 024aa763eed3f07355daff3d3258d41f
     * userInfo : {
     * "user_id":1,
     * "employee_id":"10000",
     * "username":"王万锋","
     * mobile":"18788788762",
     * "email":"115764384@qq.com",
     * "usergroup":"普通用户",
     * "status":"正常"}
     */

    private int error_code;
    private String msg;
    private String token;
    private UserInfoBean userInfo;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfoBean {
        /**
         * user_id : 1
         * employee_id : 10000
         * username : 王万锋
         * mobile : 18788788762
         * email : 115764384@qq.com
         * usergroup : 普通用户
         * status : 正常
         */

        private int user_id;
        private String employee_id;
        private String username;
        private String mobile;
        private String email;
        private String usergroup;
        private String status;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getEmployee_id() {
            return employee_id;
        }

        public void setEmployee_id(String employee_id) {
            this.employee_id = employee_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsergroup() {
            return usergroup;
        }

        public void setUsergroup(String usergroup) {
            this.usergroup = usergroup;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
