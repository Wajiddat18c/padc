/**
 * padc.dat18c.renoblvd.controller
 */
package padc.dat18c.renoblvd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import padc.dat18c.renoblvd.auth.UserService;
import padc.dat18c.renoblvd.imageshandler.DatabaseFile;
import padc.dat18c.renoblvd.imageshandler.DatabaseFileService;
import padc.dat18c.renoblvd.imageshandler.DatabaseSERVICE;
import padc.dat18c.renoblvd.imageshandler.FileInfoService;
import padc.dat18c.renoblvd.imageshandler.Response;
import padc.dat18c.renoblvd.model.*;
import padc.dat18c.renoblvd.service.*;

import javax.servlet.http.HttpServletRequest;

/**
 * This i an Controller class that routes web pages
 * This class has responsibility to handle all of the admin pages
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    NewsletterService newsletterService;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    ProductsService productsService;

    @Autowired
    UserService userService;

    @Autowired
    CustomerInformationService customerInformationService;

    @Autowired
    DatabaseFileService databaseFileService;

    @Autowired
    BasketProductsService basketProductsService;

    @Autowired
    ProductstoimagesService productstoimagesService;

    @Autowired
    DatabaseSERVICE databaseSERVICE;

    @Autowired
    FileInfoService fileInfoService;

    @Autowired
    StoreService storeService;


    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminPage() {
        return "admin/adminIndex";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = "/logout-success")
    public String getLogoutPage() {
        return "logout";
    }

//    -----------------------------------------------------------------------------------------------------------------------------------
//    CREATE


    @GetMapping("/createNewsletter")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createTeachers() {
        return "admin/news/createNewsletter";
    }

    @PostMapping("/createNewsletter")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createTeachers(@ModelAttribute Newsletter newsletter) {
        newsletterService.create(newsletter);
        return "redirect:/admin/news";
    }

    @GetMapping("/createCategory")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createCategory() {
        return "admin/category/createCategory";
    }

    @PostMapping("/createCategory")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createCategory(@ModelAttribute Categories categories) {
        categoriesService.create(categories);
        return "redirect:/admin/category";
    }

    @GetMapping("/createCustomer")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createCustomer() {
        return "admin/customerinfo/createCustomer";
    }

    @PostMapping("/createCustomer")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createCustomer(@ModelAttribute CustomerInformation customerInformation) {
        customerInformationService.create(customerInformation);
        return "redirect:/admin/customer";
    }

    @GetMapping("/createProducts")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createProducts(Model model) {
        model.addAttribute("categoryList", categoriesService.getAll());
        return "admin/products/createProducts";
    }
    @PostMapping("/createProducts")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createProducts(@ModelAttribute Products products) {
        productsService.create(products);
        return "redirect:/admin/products";
    }

    @GetMapping("/mapimgwithproduct")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createImgProd(Model model) {
        model.addAttribute("productList", productsService.getAll());
        model.addAttribute("imgList", databaseFileService.getAll());
        return "admin/images/addImgToProduct";
    }
    @PostMapping("/mapimgwithproduct")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createImgProd(@ModelAttribute Productstoimages productstoimages) {
        productstoimagesService.create(productstoimages);
        return "redirect:/admin/images/products";
    }

    @GetMapping("/uploadFile")
    public String uploadFiles(Model model) {
//        model.addAttribute("db", categoriesService.getAll());
        model.addAttribute("productsList", productsService.getAll());

        return "admin/images/uploadFiles";
    }


    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        DatabaseFile fileName = databaseFileService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();

//        return new Response(fileName.getFileName(), fileDownloadUri,
//                file.getContentType(), file.getSize());
        return "redirect:/admin/images";
    }


//    -----------------------------------------------------------------------------------------------------------------------------------
//    READ


    @GetMapping("/news")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showNewsletter(Model model) {
        model.addAttribute("newsletters", newsletterService.getAll());

        return "admin/news/showNewsletter";
    }

    @GetMapping("/category")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showCategory(Model model) {
        model.addAttribute("category", categoriesService.getAll());

        return "admin/category/showCategory";
    }


    @GetMapping("/products")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showProducts(Model model) {
        model.addAttribute("category", categoriesService.getAll());
        model.addAttribute("products", productsService.getAll());

        return "admin/products/showProducts";
    }

    @GetMapping("/storeinfo")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showStore(Model model){
        model.addAttribute("store", storeService.getAll());

        return "admin/storeinfo/showStoreInfo";
    }

    @GetMapping("/customer")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getCustomer(Model model){
        model.addAttribute("customer", customerInformationService.getAll());

        return "admin/customerinfo/showCustomer";
    }

    @GetMapping("/basket")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getBasket(Model model){
        model.addAttribute("basket", basketProductsService.getAll());
        model.addAttribute("product", productsService.getAll());
        return "admin/basket/showBaskets";
    }

    @GetMapping("/images/products")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getImg(Model model){
        model.addAttribute("product", productsService.getAll());
        model.addAttribute("imgproduct", productstoimagesService.getAll());
        return "admin/images/showImgWithProducts";
    }




    @GetMapping("/images")
    public String  downloadFile(Model model) {
//    public String  downloadFile(@PathVariable String fileName, HttpServletRequest request, Model model) {
        // Load file as Resource
//        DatabaseFile databaseFile = databaseFileService.getFile(fileName);
        model.addAttribute("img", fileInfoService.getAll());

        return "admin/images/showFiles";
    }

//    -----------------------------------------------------------------------------------------------------------------------------------
//    UPDATE

    @GetMapping("/updateNewsletter/{idNews}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateNewsletter(@PathVariable("idNews") int idNews, Model model) {
        model.addAttribute("newsletter", newsletterService.findById(idNews));
        return "admin/news/updateNewsletter";
    }

    @PostMapping("/updateNewsletter")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateNewsletter(@ModelAttribute Newsletter newsletter) {
        newsletterService.update(newsletter);
        return "redirect:/admin/news";
    }

    @GetMapping("/updateCategory/{idCategories}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCategory(@PathVariable("idCategories") int idCategories, Model model) {
        model.addAttribute("category", categoriesService.findbyId(idCategories));
        return "admin/category/updateCategory";
    }

    @PostMapping("/updateCategory")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCategory(@ModelAttribute Categories categories) {
        categoriesService.update(categories);
        return "redirect:/admin/category";
    }


    @GetMapping("/updateStoreInfo/{idStore}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateStore(@PathVariable("idStore") int idStore, Model model) {
        model.addAttribute("store", storeService.findById(idStore));
        return "admin/storeinfo/updateStoreInfo";
    }

    @PostMapping("/updateStoreInfo")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateStore(@ModelAttribute Store store) {
        storeService.update(store);
        return "redirect:/admin/storeinfo";
    }


    @GetMapping("/updateCustomer/{idcustomerInformation}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCustomer(@PathVariable("idcustomerInformation") int idcustomerInformation, Model model) {
        model.addAttribute("customer", customerInformationService.findById(idcustomerInformation));
        return "admin/customerinfo/updateCustomer";
    }

    @PostMapping("/updateCustomer")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCategory(@ModelAttribute CustomerInformation customerInformation) {
        customerInformationService.update(customerInformation);
        return "redirect:/admin/customer";
    }

    @GetMapping("/updateProducts/{idProducts}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateProducts(@PathVariable("idProducts") int idProducts, Model model) {
        model.addAttribute("products", productsService.findById(idProducts));
        model.addAttribute("categoryList", categoriesService.getAll());
        return "admin/products/updateProducts";
    }

    @PostMapping("/updateProducts")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateProducts(@ModelAttribute Products products) {
        productsService.update(products);
        return "redirect:/admin/products";
    }

    @GetMapping("/updateimg/{idProductsToImages}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateImages(@PathVariable("idProductsToImages") int idProductsToImages, Model model) {
        model.addAttribute("imgprod", productstoimagesService.findById(idProductsToImages));
        model.addAttribute("img", databaseFileService.getAll());
        model.addAttribute("productList", productsService.getAll());
        return "admin/images/updateImg";
    }

    @PostMapping("/updateimg")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateImages(@ModelAttribute Productstoimages productstoimages) {
        productstoimagesService.update(productstoimages);
        return "redirect:/admin/images/products";
    }

    @GetMapping("/updateFiles/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateFiles(@PathVariable("id") String id, Model model) {
        model.addAttribute("productsList", productsService.getAll());
        model.addAttribute("img", databaseSERVICE.findbyId(id));

        return "admin/images/updateFiles";
    }

    @PostMapping("/updateFiles")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateFiles(@ModelAttribute DatabaseFile databaseFile) {
        databaseSERVICE.update(databaseFile);
        return "redirect:/admin/images";
    }


//    -----------------------------------------------------------------------------------------------------------------------------------
//    DELETE

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteNewsletter(@PathVariable("id") int idNews) {
        newsletterService.delete(idNews);
        return "redirect:/admin/news";
    }

    @GetMapping("/deleteCategory/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCategory(@PathVariable("id") int idCategories) {
        categoriesService.delete(idCategories);
        return "redirect:/admin/category";
    }

    @GetMapping("/deleteCustomer/{idcustomerInformation}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCustomer(@PathVariable("idcustomerInformation") int idcustomerInformation) {
        customerInformationService.delete(idcustomerInformation);
        return "redirect:/admin/customer";
    }

    @GetMapping("/deleteProducts/{idProducts}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteProducts(@PathVariable("idProducts") int idProducts) {
        productsService.delete(idProducts);
        return "redirect:/admin/products";
    }

    @GetMapping("/deleteimgprod/{idProductsToImages}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteImgProd(@PathVariable("idProductsToImages") int idProductsToImages) {
        productstoimagesService.delete(idProductsToImages);
        return "redirect:/admin/images/products";
    }
}
