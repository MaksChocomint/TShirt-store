package project.tshirt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtService {

    private final TShirtRepo TShirtRepo;

    @Autowired
    public TShirtService(TShirtRepo TShirtRepo) {
        this.TShirtRepo = TShirtRepo;
    }

    public List<TShirt> getAll() {
        return TShirtRepo.findAll();
    }

    public TShirt getById(int id) {
        return TShirtRepo.findById(id).orElse(null);
    }

    public TShirt create(TShirt TShirt) {
        return TShirtRepo.save(TShirt);
    }

    public boolean update(TShirt TShirt, int id) {
        if (TShirtRepo.existsById(id)) {
            TShirt.setId(id);
            TShirtRepo.save(TShirt);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (TShirtRepo.existsById(id)) {
            TShirtRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
