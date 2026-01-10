package com.example.crud.service.iml;

import com.example.crud.entity.Shelf;
import com.example.crud.repository.ShelfRepository;
import com.example.crud.service.ShelfService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShelfServiceImpl implements ShelfService {
    private ShelfRepository repository;

    @Override
    public Shelf createShelf(Shelf shelf) {
        return repository.save(shelf);
    }

    @Override
    public String readShelf() {
        List<Shelf> shelfs = repository.findAll();

        return shelfs.stream().map(Shelf::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public Shelf updateShelf(Integer id, Shelf shelf) {
        Shelf existingShelf = repository.findById(id)
                .orElse(null);

        if (existingShelf != null) {

            existingShelf.setName(shelf.getName());
            existingShelf.setDescription(shelf.getDescription());

            return repository.save(existingShelf);
        }

        System.out.println("Полка не найдена");
        return null;
    }

    @Override
    public String deleteShelf(Integer id) {
        if (repository.existsById(id)) {
            return "Полка не найдена";
        }

        String name  = repository.findById(id).get().getName();
        repository.deleteById(id);

        return "Полка " + name + " удалена";
    }
}
