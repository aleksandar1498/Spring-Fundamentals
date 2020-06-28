package bg.softuni.shopping.common.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

public class ObjectMapper {
	private static final ModelMapper modelMapper;

	static {
		modelMapper = new ModelMapper();
	}

	public static <S, D> D map(final S source, final D destination) {
		modelMapper.map(source, destination);
		return destination;
	}

	public static <D, T> D map(final T entity, final Class<D> outClass) {
		return modelMapper.map(entity, outClass);
	}

	public static <D, T> List<D> mapAll(final Collection<T> entityList, final Class<D> outCLass) {
		return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
	}

	/**
	 * Hide from public usage.
	 */
	private ObjectMapper() {
	}
}
