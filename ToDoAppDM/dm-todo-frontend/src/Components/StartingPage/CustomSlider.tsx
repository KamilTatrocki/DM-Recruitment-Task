
import Slider from 'react-slick'
import "slick-carousel/slick/slick.css"
import "slick-carousel/slick/slick-theme.css"

const slides = [
  {
    id: 1,
    title: "Create Tasks Easily",
    description: "You can quickly create and organize tasks with just a few clicks",
  },
  {
    id: 2,
    title: "Follow expiration dates",
    description: "You can browse products with short expiration dates",
  },
  {
    id: 3,
    title: "Check products",
    description: "You can check all the products available in the shop",
  },
]

const CustomSlider= () => {
  const settings = {
    dots: true,
    arrows: false,
    infinite: true,
    speed: 800,
    slidesToShow: 1,
    autoplay: true,
    autoplaySpeed: 4000,
    pauseOnHover: true,
    centerMode: false,
  }

  return (
    <div className="w-full bg-gradient-to-b from-[var(--c5)] to-[var(--c3)] ">
      <div className="max-w-xl mx-auto min-h-[250px] sm:h-[450px] py-16">
        <Slider {...settings}>
          {slides.map(({ id, title, description }) => (
            <div
              key={id}
              className="h-full flex items-center justify-center px-4"
            >
              <div
                className="
                  relative
                  bg-[var(--c2)]
                  rounded-2xl
                  shadow-lg
                  p-8
                  sm:min-h-[350px]
                  sm:min-w-[450px]
                  flex
                  flex-col
                  items-center
                  justify-center
                  text-center
                 
                "
              >
                <h2 className="text-3xl sm:text-5xl font-bold text-[var(--c6)]">
                  {title}
                </h2>
                <p className="mt-4 text-lg sm:text-xl text-[var(--c5)]">
                  {description}
                </p>
              </div>
            </div>
          ))}
        </Slider>
      </div>
    </div>
  )
}

export default CustomSlider
