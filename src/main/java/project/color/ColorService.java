package project.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    private final ColorRepo colorRepo;

    @Autowired
    public ColorService(ColorRepo colorRepo) {
        this.colorRepo = colorRepo;
    }

    public List<Color> getAll() {
        return colorRepo.findAll();
    }

    public Color getById(int id) {
        return colorRepo.findById(id).orElse(null);
    }

    public Color create(Color color) {
        return colorRepo.save(color);
    }

    public boolean update(Color color, int id) {
        if (colorRepo.existsById(id)) {
            color.setId(id);
            colorRepo.save(color);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (colorRepo.existsById(id)) {
            colorRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
