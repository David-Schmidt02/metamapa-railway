function SourceCard({ text, alignRight, scrollOffset, delay, imageSrc }) {
    const startPos = 150;

    let translateXDistance = startPos - scrollOffset;

    if (translateXDistance < 0) {
        translateXDistance = 0;
    }

    const finalTransform = alignRight
        ? `translateX(-${translateXDistance}px)`
        : `translateX(${translateXDistance}px)`;


    const transitionStyle = {
        transform: finalTransform,
        opacity: 1 - translateXDistance / startPos,
        transition: `opacity 0.1s ease-out, transform 0.1s ease-out`,
        backgroundColor: '#e69553',
        borderRadius: '50px',
        padding: '20px 40px',
        margin: '20px 0',
        color: 'white',
        fontWeight: '500',
        minHeight: '120px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        flexDirection: alignRight ? 'row-reverse' : 'row',
    };

    const imageStyle = {
        backgroundColor: '#ccc',
        borderRadius: '50%',
        width: '80px',
        height: '80px',
        flexShrink: 0,
        margin: alignRight ? '0 0 0 20px' : '0 20px 0 0',
        objectFit: 'cover',
    };

    return (
        <div
            style={{ ...transitionStyle, transitionDelay: `${delay}s` }}
            className="col-12 col-md-8 mx-auto"
        >
            {imageSrc ? (
                <img src={imageSrc} alt="source" style={imageStyle} />
            ) : (
                <div style={imageStyle} />
            )}
            <p className="mb-0 text-start">{text}</p>
        </div>
    );
};

export default SourceCard;