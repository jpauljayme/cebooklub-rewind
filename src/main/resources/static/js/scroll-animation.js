document.addEventListener('DOMContentLoaded', function(){
    const books = document.querySelectorAll('.books__row');

    const observerOptions = {
    root: null,
        rootMargin: '100px 0px',
        threshold: 0.5

    }

    const observer = new IntersectionObserver( entries => {
        entries.forEach( entry => {
            if(entry.isIntersecting){
                entry.target.classList.add('book--visible');
                observer.unobserve(entry.target);
            }else{
                 entry.target.classList.remove('book--visible');
            }
        });
    }, observerOptions);

    books.forEach(book => {
        observer.observe(book);
            book.addEventListener('transitionend', () => {
                // Re-observe if needed after animation completes
                observer.observe(book);
            });
    });
});