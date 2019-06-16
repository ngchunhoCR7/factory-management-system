package factory.management.system.project.entity;

import javax.persistence.*;

@Table(name = "t_admin")
public class Admin {
    @Id
    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_password")
    private String adminPassword;

    /**
     * 管理员角色
     */
    @Column(name = "admin_role")
    private Integer adminRole;

    private String note;

    /**
     * @return admin_id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * @param adminId
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * @return admin_name
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * @param adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * @return admin_password
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * @param adminPassword
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    /**
     * 获取管理员角色
     *
     * @return admin_role - 管理员角色
     */
    public Integer getAdminRole() {
        return adminRole;
    }

    /**
     * 设置管理员角色
     *
     * @param adminRole 管理员角色
     */
    public void setAdminRole(Integer adminRole) {
        this.adminRole = adminRole;
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}