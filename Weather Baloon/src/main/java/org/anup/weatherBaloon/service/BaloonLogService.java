package org.anup.weatherBaloon.service;


import java.util.List;

import org.anup.weatherBaloon.model.BaloonLog;

public interface BaloonLogService {
	
	BaloonLog findById(Long id);

	void saveBaloon(BaloonLog baloon);

	void updateBaloon(BaloonLog baloon);

	void deleteBaloonLogById(Long id);

	void deleteAllBaloonLogs();

	List<BaloonLog> findAllBaloonLogs();

}