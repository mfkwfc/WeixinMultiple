package porridge.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import porridge.business.WxAccountBusiness;
import porridge.mapper.WxAccountMapper;
import porridge.model.WxAccount;

import java.util.List;
import java.util.Random;

@Service
@EnableTransactionManagement
public class WxAccountBusinessImpl implements WxAccountBusiness {
   @Autowired
   WxAccountMapper wxAccountMapper;
	
    @Override
    public WxAccount add(WxAccount account) {
        return null;
    }

    @Override
    public WxAccount update(WxAccount account) {
        return null;
    }

    @Override
    public boolean updateStatus(String name, Integer status) {
        return false;
    }

    @Override
    public List<WxAccount> list() {
        return null;
    }

	@Override
	public WxAccount findByName(String name) {
        String tab = new Random().nextInt (10)%2==0? "wx_accounts":"wx_accounts_back";
		return wxAccountMapper.findByName(name);
	}
}
