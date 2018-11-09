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
			id = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			id = null;
		}

		if (id != null) {
			EmpresaDAO dao = new EmpresaDAO();

			Empresa emp = dao.lerPorId(id);
			return emp;
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value instanceof Empresa) {

			Empresa emp = (Empresa) value;

			return emp.toString();
		}

		return null;
	}

}
