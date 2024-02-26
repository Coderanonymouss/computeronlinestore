package kz.satbayev.onlinestore.service;

import kz.satbayev.onlinestore.model.entity.*;
import kz.satbayev.onlinestore.model.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class AllCategoriesService {

    private final CategoryRepository categoryRepository;
    private final RAMCategoryRepository ramCategoryRepository;
    private final VideoCardCategoryRepository videoCardCategoryRepository;
    private final ProcessorCategoryRepository processorCategoryRepository;
    private final MatrixCategoryRepository matrixCategoryRepository;
    private final CoolerCategoryRepository coolerCategoryRepository;

    public AllCategoriesService(CategoryRepository categoryRepository, RAMCategoryRepository ramCategoryRepository, VideoCardCategoryRepository videoCardCategoryRepository, ProcessorCategoryRepository processorCategoryRepository, MatrixCategoryRepository matrixCategoryRepository, CoolerCategoryRepository coolerCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.ramCategoryRepository = ramCategoryRepository;
        this.videoCardCategoryRepository = videoCardCategoryRepository;
        this.processorCategoryRepository = processorCategoryRepository;
        this.matrixCategoryRepository = matrixCategoryRepository;
        this.coolerCategoryRepository = coolerCategoryRepository;
    }



    public List<CoolerCategories> getAllCooler() {
        return coolerCategoryRepository.findAll();
    }


    public CoolerCategories getCooler(long id) {
        return coolerCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }


    public List<ProcessorCategories> getAllProcessor() {
        return processorCategoryRepository.findAll();
    }


    @Transactional
    public ProcessorCategories getProcessor(long id) {
        return processorCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }


    public List<MatrixCategories> getAllMatrix() {
        return matrixCategoryRepository.findAll();
    }


    public MatrixCategories getMatrix(long id) {
        return matrixCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }


    public List<RAMCategories> getAllRAM() {
        return ramCategoryRepository.findAll();
    }


    public RAMCategories getRAM(long id) {
        return ramCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }


    public List<VideoCardCategories> getAllVideoCard() {
        return videoCardCategoryRepository.findAll();
    }


    public VideoCardCategories getVideoCard(long id) {
        return videoCardCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }





    public Model getAll(Model model) {
        List<CoolerCategories> coolers = getAllCooler();
        model.addAttribute("coolers", coolers);
        List<MatrixCategories> matrices = getAllMatrix();
        model.addAttribute("matrices", matrices);
        List<ProcessorCategories> processors = getAllProcessor();
        model.addAttribute("processors", processors);
        List<RAMCategories> rams = getAllRAM();
        model.addAttribute("rams", rams);
        List<VideoCardCategories> videoCards = getAllVideoCard();
        model.addAttribute("videoCards", videoCards);
        return model;
    }

    public Long getAllPrice(Categories categories) {
        return categories.getCoolerCategories().getPrice() + categories.getMatrixCategories().getPrice() + categories.getProcessorCategories().getPrice() + categories.getRamCategories().getPrice() + categories.getVideoCardCategories().getPrice();
    }


    public List<Categories> getSearchOrder(String name) {
        return categoryRepository.findAllByNameIsContainingIgnoreCase(name);
    }
}
