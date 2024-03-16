package project.tshirt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/tshirts")
@CrossOrigin(origins = "http://localhost:3000")
public class TShirtController {
    private final TShirtService TShirtService;

    @Autowired
    public TShirtController(TShirtService TShirtService) {
        this.TShirtService = TShirtService;
    }

    @GetMapping
    public List<TShirt> getTShirts() {
        return TShirtService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TShirt> getTShirtById(@PathVariable int id) {
        TShirt TShirt = TShirtService.getById(id);
        if (TShirt != null) {
            return ResponseEntity.ok(TShirt); // Возвращаем футболку с кодом 200 (ОК)
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем ошибку 404 (Not Found)
        }
    }

    @PostMapping
    public TShirt addTShirt(@RequestBody TShirt TShirt) {
        return TShirtService.create(TShirt);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTShirt(@PathVariable int id, @RequestBody TShirt TShirt) {
        boolean updated = TShirtService.update(TShirt, id);
        if (updated) {
            return ResponseEntity.ok("TShirt updated successfully");
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем ошибку 404, если цвет не был найден
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTShirt(@PathVariable int id) {
        boolean deleted = TShirtService.delete(id);
        if (deleted) {
            return ResponseEntity.ok("TShirt deleted successfully");
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем ошибку 404, если цвет не был найден
        }
    }
}
