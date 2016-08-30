using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using CaelumEstoque.DAO;
using CaelumEstoque.Models;
using CaelumEstoque.Filtros;

namespace CaelumEstoque.Controllers
{
    [AutorizacaoFilter]
    public class ProdutoController : Controller
    {
        // GET: Produto
        [Route("produtos", Name="ListaProduto")]
        public ActionResult Index()
        {
            ProdutosDAO dao = new ProdutosDAO();
            IList<Produto> produtos = dao.Lista();
            return View(produtos);
        }

        public ActionResult Form() 
        {
            CategoriasDAO dao = new CategoriasDAO();
            IList<CategoriaDoProduto> categoria = dao.Lista();
            ViewBag.CategoriaDoProduto = categoria;
            ViewBag.Produto = new Produto();
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Adiciona(Produto produto) 
        {
            int idInformatica = 1;
            if (produto.CategoriaId.Equals(idInformatica) && produto.Preco < 100) 
            {
                ModelState.AddModelError("produto.InformaticaComPrecoInvalido", "Produtos de informática precisam ter o preço maior do que 100");
            }

            if (ModelState.IsValid)
            {
                ProdutosDAO dao = new ProdutosDAO();
                dao.Adiciona(produto);

                return RedirectToAction("Index", "Produto");
            }
            else
            {
                CategoriasDAO dao = new CategoriasDAO();
                IList<CategoriaDoProduto> categoria = dao.Lista();
                ViewBag.CategoriaDoProduto = categoria;
                ViewBag.Produto = produto;
                return View("Form");
            }
        }
        [Route("produtos/{id}", Name = "VisualizaProduto")]
        public ActionResult Visualiza(int id) {
            ProdutosDAO dao = new ProdutosDAO();
            Produto produto = dao.BuscaPorId(id);
            ViewBag.Produto = produto;
            return View();
        }

        public ActionResult DecrementaQtd(int id)
        {
            ProdutosDAO dao = new ProdutosDAO();
            Produto produto = dao.BuscaPorId(id);
            produto.Quantidade--;
            dao.Atualiza(produto);

            return Json(produto);
        }
    }
}