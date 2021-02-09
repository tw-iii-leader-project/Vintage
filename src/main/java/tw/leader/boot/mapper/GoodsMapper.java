	package tw.leader.boot.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import tw.leader.boot.domain.*;

public interface GoodsMapper {
	
	@Select("select * from TA_TestGoods order by pId offset (${pageNo}-1)*${pageSize} rows fetch next ${pageSize} rows only")
	List<Goods> getListByPage(int pageSize,int pageNo);
	
	@Select("select * from TA_TestGoods where categorypId=#{categorypId} order by pId")
	List<Goods> getList(int categoryId);
	
	@Select("<script>select * from TA_TestGoods where pId in " 
			+"<foreach item='item' index='index' collection='pIds' open='(' separator=',' close=')'>#{item}</foreach>"
			+"order by pId</script>")
	List<Goods> getListByMultpIds(@Param("pIds")int...pIds);
	
	/*
	 * @Select("select * from TA_TestGoods where pId=#{pId}") Goods get(int pId);
	 */
	

	/*
	 * @Insert(
	 * value="insert into TA_TestGoods(pName, picture, price, description, categorypId, "
	 * +
	 * "userName, lastEditTime) values(#{pName},#{picture},#{price},#{description},#{categorypId},#{userName},getdate())"
	 * )
	 * 
	 * @Options(useGeneratedKeys=true,keyProperty="pId",keyColumn="pId") vopId
	 * insert(Goods goods);
	 */
	
	@Select("select * from TA_TestGoods where pId=#{id}")
	Goods get(int pId);
	
	@Insert(value="insert into TA_TestGoods(pName, cPhoto, price, description, categoryId, "
			+ "userName, lastEditTime) values(#{title},#{picture},#{price},#{introduction},#{categoryId},#{lastEditBy},getdate())")
	@Options(useGeneratedKeys=true,keyProperty="pId",keyColumn="pId")
	void insert(Goods goods);
	
	@Delete(value="delete from TA_TestGoods where pId=#{id}")
	void delete(int pId);
	
	@Update("update TA_TestGoods set pName=#{title},cPhoto=#{picture},price=#{price},description=#{introduction}," + 
			"categoryId=#{categoryId},userName=#{lastEditBy},lastEditTime=getdate(),pMain=#{pMain},pDetail=#{pDetail}  " + 
			"where pId=#{pId}")
	void update(Goods goods);
	
	
}
