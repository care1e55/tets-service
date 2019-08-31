package testservice.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Task {

	private final UUID id;
	private LocalDateTime timestamp;
	private String status;

	public Task(UUID id, LocalDateTime timestamp, String status) {
		this.id = id;
		this.timestamp = timestamp;
		this.status = status;
	}

}
