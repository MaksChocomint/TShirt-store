package project.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.tshirt.TShirt;

import java.util.List;

@RestController
@RequestMapping("api/v1/colors")
@CrossOrigin(origins = "http://localhost:3000")
public class ColorController {

    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public List<Color> getColors() {
        return colorService.getAll();
    }

    @PostMapping
    public Color addColor(@RequestBody Color color) {
        return colorService.create(color);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getColorById(@PathVariable int id) {
        Color color = colorService.getById(id);
        if (color != null) {
            return ResponseEntity.ok(color); // Возвращаем цвет с кодом 200 (ОК)
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем ошибку 404 (Not Found)
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateColor(@PathVariable int id, @RequestBody Color color) {
        boolean updated = colorService.update(color, id);
        if (updated) {
            return ResponseEntity.ok("Color updated successfully");
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем ошибку 404, если цвет не был найден
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteColor(@PathVariable int id) {
        boolean deleted = colorService.delete(id);
        if (deleted) {
            return ResponseEntity.ok("Color deleted successfully");
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем ошибку 404, если цвет не был найден
        }
    }
}
