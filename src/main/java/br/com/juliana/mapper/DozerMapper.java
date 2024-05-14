package br.com.juliana.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    //converter apenas um dado
    public static <O, D> D parseObject(O origin, Class<D> destination){

        return mapper.map(origin, destination);

    }

    //converter a listagem de dados
    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination){

        List<D> destionationObjects = new ArrayList<D>();
        for (O o : origin) {
            destionationObjects.add(mapper.map(o, destination));
        }

        return destionationObjects;

    }

}
