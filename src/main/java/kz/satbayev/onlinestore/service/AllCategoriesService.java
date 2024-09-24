package kz.satbayev.onlinestore.service;

import kz.satbayev.onlinestore.model.entity.*;
import org.springframework.ui.Model;

import java.util.List;

public interface AllCategoriesService {

    List<CoolerCategories> getAllCooler();

    CoolerCategories getCooler(long id);

    List<ProcessorCategories> getAllProcessor();

    ProcessorCategories g etProcessor(long id);

    List<MatrixCategories> getAllMatrix();

    MatrixCategories getMatrix(long id);

    List<RAMCategories> getAllRAM();

    RAMCategories getRAM(long id);

    List<VideoCardCategories> getAllVideoCard();

    VideoCardCategories getVideoCard(long id);

    Model getAll(Model model);

    Long getAllPrice(Categories categories);

    List<Categories> getSearchOrder(String name);

}
