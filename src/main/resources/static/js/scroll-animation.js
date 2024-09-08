document.addEventListener('DOMContentLoaded', function(){
    const observerOptions = {
        rootMargin: '0px',
        threshold: 0.4
    }

    const observer = new IntersectionObserver( entries => {
        entries.forEach( entry => {
            if(entry.isIntersecting){
                entry.target.classList.add('book--visible');
            }else{
                 entry.target.classList.remove('book--visible');
            }
        });
    });

    const hiddenBooks = document.querySelectorAll('.books__row');
    hiddenBooks.forEach(book => observer.observe(book));

//    window.addEventListener('scroll', function(){
//        hiddenBooks.forEach(book => {
//            const rect = book.getBoundingClientRect();
//            if (rect.top <= 0 && rect.bottom >= 0) {
//                book.classList.add('sticky');
//            } else {
//                book.classList.remove('sticky');
//            }
//        });
//    });
});

