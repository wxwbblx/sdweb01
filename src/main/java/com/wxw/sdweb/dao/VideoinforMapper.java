package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.Program;
import com.wxw.sdweb.vo.Videoinfor;
@Mapper
public interface VideoinforMapper {
	@Select("select * from videoinfor where vid  = #{vid}  order by id asc")
	public List<Videoinfor> findByVid(int vid);
	
	@Select("select * from videoinfor where vid= #{arg0} and vname=#{arg1} order by vid asc,vname asc")
	public Videoinfor findByVidid(int vid,String vname);
	
	@Insert("insert into videoinfor (vid,vname,sname,vlable,vurl,vremark) values( #{vid},#{vname},#{sname},#{vlable},#{vurl},#{vremark})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Videoinfor videoinfor);
	
	
	
	@Delete("delete from videoinfor where id  = #{id}")
	public int delete(int id);

	//@Update("update program set pdate=#{pdate,jdbcType=DATE},pstime=#{pstime,jdbcType=VARCHAR},pname=#{pname,jdbcType=VARCHAR},plength=#{plength,jdbcType=INTEGER},purl=#{purl,jdbcType=VARCHAR},remark=#{remark,jdbcType=VARCHAR},isnew=#{isnew,jdbcType=VARCHAR},ptype=#{ptype,jdbcType=VARCHAR} from where id = #{id}")
	
	@Update("update videoinfor set pdate=#{pdate},pstime=#{pstime},pname=#{pname},plength=#{plength},purl=#{purl},remark=#{remark},"
			+ "isnew=#{isnew},ptype=#{ptype} where id = #{id}")
	public int update(Videoinfor videoinfor);
}
