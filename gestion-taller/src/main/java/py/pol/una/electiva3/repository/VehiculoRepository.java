package py.pol.una.electiva3.repository;

import org.springframework.data.repository.CrudRepository;

import py.pol.una.electiva3.entity.Vehiculo;
import py.pol.una.electiva3.entity.VehiculoPK;

public interface VehiculoRepository extends CrudRepository<Vehiculo, VehiculoPK> {

}
