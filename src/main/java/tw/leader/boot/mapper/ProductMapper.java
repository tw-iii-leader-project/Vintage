package tw.leader.boot.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import tw.leader.boot.domain.*;

public interface ProductMapper {

	@Select("select * from Product order by pId offset (${pageNo}-1)*${pageSize} rows fetch next ${pageSize} rows only")
	List<Productb> getListByPage(int pageSize, int pageNo);

	@Select("select * from Product where categoryId=#{categoryId} order by pId")
	List<Productb> getList(int categoryId);

	@Select("<script>select * from Product where pId in "
			+ "<foreach item='item' index='index' collection='pIds' open='(' separator=',' close=')'>#{item}</foreach>"
			+ "order by pId</script>")
	List<Productb> getListByMultIds(@Param("pIds") int... pIds);

	@Select("<script>select * from Product where email in "
			+ "<foreach item='item' index='index' collection='email' open='(' separator=',' close=')'>#{item}</foreach>"
			+ "order by lastEditTime</script>")
	List<Productb> getListByMultiEmail(@Param("email") String... email);

	@Select("select * from Product where pId=#{pId}")
	Productb get(int pId);

	@Insert(value = "insert into Product(pName, pMain, pDetail, price, invantory,pSize, description, sDescription,"
			+ "cPhoto, email, userName,categoryId, lastEditBy, lastEditTime,categoryName) "
			+ "values(#{pName},#{pMain},#{pDetail},#{price},#{invantory},#{pSize},#{description},#{sDescription},"
			+ "#{cPhoto},#{email},#{userName},#{categoryId},#{lastEditBy},getdate(), #{categoryName})")
	@Options(useGeneratedKeys = true, keyProperty = "pId", keyColumn = "pId")
	void insert(Productb product);

	@Delete(value = "delete from Product where pId=#{pId}")
	void delete(int pId);

	@Update("update Product set pName=#{pName},pMain=#{pMain},pDetail=#{pDetail},"
			+ "price=#{price}, invantory=#{invantory}, pSize=#{pSize},decription=#{decription},sDescription=#{sDescription},cPhoto=#{cPhoto},email=#{email},userName=#{userName}"
			+ "categoryId=#{categoryId},lastEditBy=#{lastEditBy},lastEditTime=getdate(),categoryName=#{categoryName}"
			+ "where pId=#{pId}")
	void update(Productb product);

}