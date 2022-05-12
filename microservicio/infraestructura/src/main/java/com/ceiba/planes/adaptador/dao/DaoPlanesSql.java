package com.ceiba.planes.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.planes.modelo.dto.DtoPlanes;
import com.ceiba.planes.puerto.dao.DaoPlanes;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPlanesSql implements DaoPlanes, MapperResult {


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="planes", value="listar_planes")
    private static String sqlListar;



    public DaoPlanesSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPlanes> listarPlanes(Long days)  {

        List<DtoPlanes> planList = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPlanes());

            for ( DtoPlanes plan : planList) {

                 plan.setPlanValue(valueCalculate(plan.getPlanValue(), days));

            }

        return planList;
    }


}
