package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.EmpresaDAO;
import modelo.dominio.Empresa;

@FacesConverter(forClass=Empresa.class)
public class EmpresaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Integer id = null;
		try {
			
			System.out.println("ID 1" + id); /* null */
			System.out.println("value 1 " + value); /* 3 */
			id = Integer.parseInt(value);
			System.out.println("id 2 " + id); /* 3 */
		} catch (NumberFormatException e) {
			id = null;
			System.out.println("id catch " + id);
		}

		if (id != null) {
			EmpresaDAO dao = new EmpresaDAO();
			System.out.println("if id " + id); /* 3 */
			

			Empresa empresa = dao.lerPorId(id);
			System.out.println(dao.lerPorId(id)); /* 3 */
			return empresa;
		}
	

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value instanceof Empresa) {
			Empresa empresa = (Empresa) value;
			System.out.println("VALUE >> " + value);
			return empresa.toString();
		}

		return null;
	}

}
