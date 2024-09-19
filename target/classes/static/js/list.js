const productListSection = document.querySelector('.product-list-section');
const gridViewBtn = document.getElementById('grid-view-btn');
const listViewBtn = document.getElementById('list-view-btn');

listViewBtn.addEventListener('click', e => {
    productListSection.classList.remove('grid');
    productListSection.classList.add('list');
});
gridViewBtn.addEventListener('click', e => {
    productListSection.classList.remove('list');
    productListSection.classList.add('grid');
});
