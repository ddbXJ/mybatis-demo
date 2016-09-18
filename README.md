这个project是用来写一些方便的mybatis相关的demo测试

com.lxj.util.MyBatisUtil类
> 封装了读取数据源并打开sqlSession的操作,默认会从classpath:conf.xml中读取
如果测试用的数据库有变,可以直接修改conf.xml,
也可以重新写一个conf文件,调用MyBatisUtil.setResourcePath()方法

test.java.SimpleTest
> 可以进行简单的mapper测试
1. 在resource下面新建一个xxxMapper.xml,在里面写sql语句,注意记住命名空间namespace
2. 在java.com.lxj.mapping里写好对应的mapper类(interface)
3. mapper里如果用到了自定义的Domain,则定义在java.com.lxj.domain里
4. 在conf里配置所用到的db,并添加mapper标签
5. 在SimpleTest里添加自己的test方法,进行测试

GeneratorMain
> 会读取generator.xml里填的table,并自动生成mybatis gene类,包含
> > XxxDTO.java 
XxxDTOExample.java 
XxxDTOMapper.java 
XxxDTOMapper.xml

TestCRUDByAnnotationMapper
> 这个是针对Mapper不用xml写sql,而是写在interface的注释中的测试类
