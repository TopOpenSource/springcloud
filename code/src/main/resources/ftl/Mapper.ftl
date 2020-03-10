<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.sdstc.system.dao.CustomerDao">
	
	<resultMap id="CustomerMap" type="com.sdstc.system.model.Customer">
		<id column="id" property="id" />
		<result column="gmt_create" property="gmtCreate" />
	</resultMap>
	
    <sql id="CustomerCols">
        id,gmt_create,gmt_modified,create_account,modified_account,name,no,phone,email,card_image_id,address,register_date,state,pay_state,expiry_date
    </sql>
    
    <sql id="CustomerProps">
        #{id},#{gmtCreate}
    </sql>
    
    <insert id="insert" parameterType="com.sdstc.system.model.Customer">
        insert into sys_customer
        (<include refid="CustomerCols"></include>)
        values
        (<include refid="CustomerProps"></include>)
    </insert>
        
    <update id="updateSelectiveByPK" parameterType="com.sdstc.project.model.Project">
		update project
		<set>
            <if test="payComplete != null and payComplete != ''">
		        pay_complete = #{payComplete},
		    </if>
		    <if test='keyState != null'>
               key_state = #{keyState},
            </if>
		</set>
		where id = #{id} and tenant_id = #{tenantId}
	</update>
	
	<update id="updateByPK" parameterType="com.sdstc.project.model.Project">
		update project
		set project_name=#{projectName},
		where id = #{id} and tenant_id = #{tenantId}
	</update>
	
	<delete id="deleteByPK">
		delete from project
		where id = #{id} and tenant_id = #{tenantId}
	</delete>
	
	<select id="selectByPK" resultMap="CustomerMap">
		select
			<include refid="CustomerCols"></include>
		from project
		where id = #{id} and tenant_id = #{tenantId}
	</select>
	
	<select id="selectByDto"  parameterType="com.sdstc.project.model.Project" resultMap="CustomerMap">
		select
			<include refid="CustomerCols"></include>
		from project
		<where>
		    
		</where>
	</select>
</mapper>