package org.anup.weatherBaloon.service;

import java.util.List;

import org.anup.weatherBaloon.model.BaloonLog;
import org.anup.weatherBaloon.repositories.BaloonLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("baloonLogService")
@Transactional
public class BaloonLogServiceImpl implements BaloonLogService{

	@Autowired
	private BaloonLogRepository baloonLogRepository;

	@Override
	public BaloonLog findById(Long id) {
		return baloonLogRepository.findOne(id);
	}

	@Override
	public void saveBaloon(BaloonLog baloon) {
		baloonLogRepository.save(baloon);
	}

	@Override
	public void updateBaloon(BaloonLog baloon) {
		saveBaloon(baloon);
	}

	@Override
	public void deleteBaloonLogById(Long id) {
		baloonLogRepository.delete(id);
	}

	@Override
	public void deleteAllBaloonLogs() {
		baloonLogRepository.deleteAll();
	}

	@Override
	public List<BaloonLog> findAllBaloonLogs() {
		return baloonLogRepository.findAll();
	}
}
