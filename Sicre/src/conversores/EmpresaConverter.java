package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.EmpresaDAO;
import modelo.dominio.Empresa;

@FacesConverter(forClass = Empresa.class)
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

			Empresa empresa = dao.lerPorId(id);

			return empresa;
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value instanceof Empresa) {
			Empresa empresa = (Empresa) value;

			return empresa.toString();
		}

		return null;
	}

}
