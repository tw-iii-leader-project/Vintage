	package tw.leader.boot.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import tw.leader.boot.domain.*;

public interface ProductMapper {
	
	@Select("select * from Product order by pId offset (${pageNo}-1)*${pageSize} rows fetch next ${pageSize} rows only")
	List<Product> getListByPage(int pageSize,int pageNo);
	
	@Select("select * from Product where categoryId=#{categoryId} order by pId")
	List<Product> getList(int categoryId);
	
	@Select("<script>select * from Product where pId in " 
			+"<foreach item='item' index='index' collection='pIds' open='(' separator=',' close=')'>#{item}</foreach>"
			+"order by pId</script>")
	List<Product> getListByMultIds(@Param("pIds")int...pIds);
	
	@Select("select * from Product where pId=#{pId}")
	Product get(int pId);
	

	@Insert(value="insert into Product(pName, cPhoto, price, description, categoryId, "
			+ "lastEditBy, lastEditTime) values(#{pName},#{cPhoto},#{price},#{description},#{categoryId},#{lastEditBy},getdate())")
	@Options(useGeneratedKeys=true,keyProperty="pId",keyColumn="pId")
	void insert(Product product);
	
	@Delete(value="delete from Product where pId=#{pId}")
	void delete(int pId);
	
	@Update("update Product set pName=#{pName},cPhoto=#{cPhoto},price=#{price},decription=#{decription}," + 
			"categoryId=#{categoryId},lastEditBy=#{lastEditBy},lastEditTime=getdate()  " + 
			"where pId=#{pId}")
	void update(Product product);
	
	
}
