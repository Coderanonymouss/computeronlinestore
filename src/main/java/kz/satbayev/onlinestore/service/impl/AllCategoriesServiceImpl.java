package kz.satbayev.onlinestore.service.impl;

import kz.satbayev.onlinestore.model.entity.*;
import kz.satbayev.onlinestore.model.repository.*;
import kz.satbayev.onlinestore.service.AllCategoriesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class AllCategoriesServiceImpl implements AllCategoriesService {

    private final CategoryRepository categoryRepository;
    private final RAMCategoryRepository ramCategoryRepository;
    private final VideoCardCategoryRepository videoCardCategoryRepository;
    private final ProcessorCategoryRepository processorCategoryRepository;
    private final MatrixCategoryRepository matrixCategoryRepository;
    private final CoolerCategoryRepository coolerCategoryRepository;

    public AllCategoriesServiceImpl(CategoryRepository categoryRepository, RAMCategoryRepository ramCategoryRepository, VideoCardCategoryRepository videoCardCategoryRepository, ProcessorCategoryRepository processorCategoryRepository, MatrixCategoryRepository matrixCategoryRepository, CoolerCategoryRepository coolerCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.ramCategoryRepository = ramCategoryRepository;
        this.videoCardCategoryRepository = videoCardCategoryRepository;
        this.processorCategoryRepository = processorCategoryRepository;
        this.matrixCategoryRepository = matrixCategoryRepository;
        this.coolerCategoryRepository = coolerCategoryRepository;
    }


    @Override
    public List<CoolerCategories> getAllCooler() {
        return coolerCategoryRepository.findAll();
    }

    @Override
    public CoolerCategories getCooler(long id) {
        return coolerCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }

    @Override
    public List<ProcessorCategories> getAllProcessor() {
        return processorCategoryRepository.findAll();
    }

    @Override
    @Transactional
    public ProcessorCategories getProcessor(long id) {
        return processorCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }

    @Override
    public List<MatrixCategories> getAllMatrix() {
        return matrixCategoryRepository.findAll();
    }

    @Override
    public MatrixCategories getMatrix(long id) {
        return matrixCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }

    @Override
    public List<RAMCategories> getAllRAM() {
        return ramCategoryRepository.findAll();
    }

    @Override
    public RAMCategories getRAM(long id) {
        return ramCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }

    @Override
    public List<VideoCardCategories> getAllVideoCard() {
        return videoCardCategoryRepository.findAll();
    }

    @Override
    public VideoCardCategories getVideoCard(long id) {
        return videoCardCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }




    @Override
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

    @Override
    public Long getAllPrice(Categories categories) {
        return categories.getCoolerCategories().getPrice() + categories.getMatrixCategories().getPrice() + categories.getProcessorCategories().getPrice() + categories.getRamCategories().getPrice() + categories.getVideoCardCategories().getPrice();
    }


    @Override
    public List<Categories> getSearchOrder(String name) {
        return categoryRepository.findAllByNameIsContainingIgnoreCase(name);
    }
}
