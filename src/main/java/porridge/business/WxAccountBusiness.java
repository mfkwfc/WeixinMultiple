package porridge.business;

import java.util.List;

import porridge.model.WxAccount;

/**
 * 微信公众号管理
 */
public interface WxAccountBusiness {
    /**
     * 保存公众号
     * @param account
     * @return
     */
    WxAccount add(WxAccount account);

    /**
     * 修改公众号
     * @param account
     * @return
     */
    WxAccount update(WxAccount account);

    /**
     * 修改公众号状态
     * @param name
     * @param status
     * @return
     */
    boolean updateStatus(String name, Integer status);

    /**
     * 查询所有的公众号
     * @return
     */
    List<WxAccount> list();
    /**
     * 通过名称查询公众号
     * @param name
     * @return
     */
    WxAccount findByName(String name);
}
