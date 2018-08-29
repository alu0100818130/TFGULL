import static org.junit.Assert.*;
import java.sql.Connection;
import java.util.Date;
import org.junit.Test;
import dao.Conexion;
import dao.Operaciones;

public class TestDAO {
	
	@Test
	public void testBDDAccess() {
		// También cubre la creación de la BBDD
		Conexion conn = new Conexion();
		conn.accederBD(false);
	}
	
	@Test
	public void testBDDCloseCon() {
		Conexion conn = new Conexion();
		conn.accederBD(false);
		conn.cerracon();
	}
	
	@Test
	public void testCountFromDB() {
		Conexion conn = new Conexion();
		Operaciones op = new Operaciones();
		Connection cn = conn.accederBD(false);
		assertEquals("0", op.countFromDB("NAME = 'TEST' AND EDITION = 'TEST' AND RARITY = 'COMMON' AND RESERV = 'NO' AND ONUSE = 'NO'", cn));
	}
	
	@Test
	public void testInsert() {
		Conexion conn = new Conexion();
		Operaciones op = new Operaciones();
		Connection cn = conn.accederBD(false);
		assertTrue(op.insert("NAME, EDITION, RARITY, CNT, RESERV, ONUSE, LASTREV, MINPR, TENDPR, FOILPR", "'TEST','TEST', 'COMMON', '3','NO','NO','" + new Date() + "','1','10','15'", cn));
		// Borrado a través del insert (value 0).
		assertTrue(op.insert("NAME, EDITION, RARITY, CNT, RESERV, ONUSE, LASTREV, MINPR, TENDPR, FOILPR", "'TEST','TEST', 'COMMON', '0','NO','NO','" + new Date() + "','1','10','15'", cn));
	}
	
	@Test
	public void testDelete() {
		Conexion conn = new Conexion();
		Operaciones op = new Operaciones();
		Connection cn = conn.accederBD(false);
		op.delete("NAME = 'TEST' AND EDITION = 'TEST' AND RESERV = 'NO' AND ONUSE = 'NO'", cn);
	}
	
	@Test
	public void testGetCartas() {
		// Hace uso también del Select(), asi que este será también el test para dicho método.
		Conexion conn = new Conexion();
		Operaciones op = new Operaciones();
		Connection cn = conn.accederBD(false);
		assertNotEquals(null, op.getCartas(cn));
	}
	
}
