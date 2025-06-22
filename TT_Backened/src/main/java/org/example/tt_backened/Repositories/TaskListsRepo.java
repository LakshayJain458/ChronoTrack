package org.example.tt_backened.Repositories;

import org.example.tt_backened.Entities.TaskLists;
import org.example.tt_backened.Entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskListsRepo extends JpaRepository<TaskLists, UUID> {
}
