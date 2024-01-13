package model.auxResponseSOAP;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListaHabitaciones{

	@JsonProperty("HabitacionesValCombinacionesDto")
	private List<HabitacionesValCombinacionesDtoItem> habitacionesValCombinacionesDto;

	public void setHabitacionesValCombinacionesDto(List<HabitacionesValCombinacionesDtoItem> habitacionesValCombinacionesDto){
		this.habitacionesValCombinacionesDto = habitacionesValCombinacionesDto;
	}

	public List<HabitacionesValCombinacionesDtoItem> getHabitacionesValCombinacionesDto(){
		return habitacionesValCombinacionesDto;
	}

	@Override
 	public String toString(){
		return 
			"ListaHabitaciones{" + 
			"habitacionesValCombinacionesDto = '" + habitacionesValCombinacionesDto + '\'' + 
			"}";
		}
}