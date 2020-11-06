package co.com.swiii.registrotemperatura.converter;

import co.com.swiii.registrotemperatura.entity.EmpleadoEntity;
import co.com.swiii.registrotemperatura.model.Empleado;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmpleadoConverter {

    public Empleado entityToModel(EmpleadoEntity empleadoEntity) {

        var empleado = new Empleado();
        empleado.setId(empleadoEntity.getId());
        empleado.setNombre(empleadoEntity.getNombre());
        empleado.setFechaNacimiento(empleadoEntity.getEdad());
        //IMPORTANTE--BeanUtils.copyProperties(empleadoEntity,empleado);
        return empleado;
    }

    public EmpleadoEntity modelToEntity(Empleado empleado) {

        var empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setId(empleado.getId());
        empleadoEntity.setNombre(empleado.getNombre());
        empleadoEntity.setEdad(empleado.getFechaNacimiento());

        return empleadoEntity;
    }

    public List<Empleado> entityToModel(List<EmpleadoEntity> empleadosEntity) {
        List<Empleado> empleados = new ArrayList<>(empleadosEntity.size());
        empleadosEntity.forEach(entity -> empleados.add(entityToModel(entity)));
        return empleados;
    }

    public Empleado entityToModel(Optional<EmpleadoEntity> empleadoEntity) {
        Empleado empleado = null;
        if (empleadoEntity.isPresent()) {
            empleado = new Empleado();
            empleado.setId(empleadoEntity.get().getId());
            empleado.setNombre(empleadoEntity.get().getNombre());
            empleado.setFechaNacimiento(empleadoEntity.get().getEdad());

            return empleado;
        }
        return empleado;

    }
}
