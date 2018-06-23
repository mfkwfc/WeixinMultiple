package porridge.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import io.lettuce.core.dynamic.annotation.Param;
import porridge.model.WxAccount;

@Mapper
public interface WxAccountMapper {
	@Select("SELECT * FROM wx_accounts WHERE name=#{name}")
    WxAccount findByName(@Param("name") String name);
}
